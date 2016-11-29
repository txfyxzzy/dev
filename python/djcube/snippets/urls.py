from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from rest_framework.routers import DefaultRouter
from rest_framework import routers
from rest_framework import renderers
from django.conf.urls import include
from snippets import views

from snippets.views import SnippetViewSet, UserViewSet, api_root

snippet_list = SnippetViewSet.as_view({
    'get': 'list',
    'post': 'create'
})
snippet_detail = SnippetViewSet.as_view({
    'get': 'retrieve',
    'put': 'update',
    'patch': 'partial_update',
    'delete': 'destroy'
})
snippet_highlight = SnippetViewSet.as_view({
    'get': 'highlight'
}, renderer_classes=[renderers.StaticHTMLRenderer])

user_list = UserViewSet.as_view({
    'get': 'list'
})
user_detail = UserViewSet.as_view({
    'get': 'retrieve'
})

# Routers provide an easy way of automatically determining the URL conf.
router = routers.DefaultRouter()
router.register(r'users', views.UserViewSet)
router.register(r'snippets', views.SnippetViewSet)

urlpatterns = [
    url(r'^$', views.api_root),
    url(r'^', include(router.urls)),

    # url(r'^snippets/$', views.snippet_list),
    # url(r'^snippets/(?P<pk>[0-9]+)/$', views.snippet_detail),
    # url(r'^snippets/(?P<pk>[0-9]+)/highlight/$', views.SnippetHighlight.as_view(), name='snippet-highlight'),

    url(r'^snippets/$', snippet_list, name='snippet-list'),
    url(r'^snippets/(?P<pk>[0-9]+)/$', snippet_detail, name='snippet-detail'),
    url(r'^snippets/(?P<pk>[0-9]+)/highlight/$', snippet_highlight, name='snippet-highlight'),

    url(r'^snippetsapifun/$', views.snippet_list_ex, name='snippet-list'),
    url(r'^snippetsapifun/(?P<pk>[0-9]+)/$', views.snippet_detail_ex),
    url(r'^snippetsapicls/$', views.SnippetList.as_view()),
    url(r'^snippetsapicls/(?P<pk>[0-9]+)/$', views.SnippetDetail.as_view()),

    url(r'^snippetsapiclsex/$', views.SnippetListEx.as_view()),
    url(r'^snippetsapiclsex/(?P<pk>[0-9]+)/$', views.SnippetDetailEx.as_view()),

    url(r'^snippetsapiclsexex/$', views.SnippetListExEx.as_view(), name='snippet-list'),
    url(r'^snippetsapiclsexex/(?P<pk>[0-9]+)/$', views.SnippetDetailExEx.as_view(), name='snippet-detail'),
    url(r'^snippetsapiclsexex/(?P<pk>[0-9]+)/highlight/$', views.SnippetHighlight.as_view(), name='snippet-highlight'),

    # url(r'^usersex/$', views.UserList.as_view(), name='user-list'),
    # url(r'^usersex/(?P<pk>[0-9]+)/$', views.UserDetail.as_view(), name='user-detail'),

    url(r'^usersex/$', user_list, name='user-list'),
    url(r'^usersex/(?P<pk>[0-9]+)/$', user_detail, name='user-detail'),

    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),
]

urlpatterns = format_suffix_patterns(urlpatterns)

urlpatterns += [
    url(r'^api-auth/', include('rest_framework.urls',
                               namespace='rest_framework')),
]