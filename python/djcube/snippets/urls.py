from django.conf.urls import include
from django.conf.urls import url

from rest_framework import routers
from rest_framework import renderers
from rest_framework.schemas import get_schema_view
from rest_framework.urlpatterns import format_suffix_patterns

from snippets import views
from snippets.views import SnippetViewSet, UserViewSet, api_root

schema_view = get_schema_view(title='Pastebin API')

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
    #=============response url=================
    # url(r'^snippets/$', views.snippet_list),
    # url(r'^snippets/(?P<pk>[0-9]+)/$', views.snippet_detail),
    # url(r'^snippets/(?P<pk>[0-9]+)/highlight/$', views.SnippetHighlight.as_view(), name='snippet-highlight'),

    # url(r'^snippetsex/$', views.snippet_list_ex, name='snippet-list'),
    # url(r'^snippetsex/(?P<pk>[0-9]+)/$', views.snippet_detail_ex),

    #=============view url=================
    url(r'^snippetsview/$', views.SnippetList.as_view()),
    url(r'^snippetsview/(?P<pk>[0-9]+)/$', views.SnippetDetail.as_view()),

    url(r'^snippetsviewex/$', views.SnippetListEx.as_view()),
    url(r'^snippetsviewex/(?P<pk>[0-9]+)/$', views.SnippetDetailEx.as_view()),

    url(r'^snippetsviewzz/$', views.SnippetListExEx.as_view(), name='snippet-list'),
    url(r'^snippetsviewzz/(?P<pk>[0-9]+)/$', views.SnippetDetailExEx.as_view(), name='snippet-detail'),
    url(r'^snippetsviewzz/(?P<pk>[0-9]+)/highlight/$', views.SnippetHighlight.as_view(), name='snippet-highlight'),

    url(r'^usersex/$', views.UserList.as_view(), name='user-list'),
    url(r'^usersex/(?P<pk>[0-9]+)/$', views.UserDetail.as_view(), name='user-detail'),

    #=============viewset url=================
    # url(r'^snippets/$', snippet_list, name='snippet-list'),
    # url(r'^snippets/(?P<pk>[0-9]+)/$', snippet_detail, name='snippet-detail'),
    # url(r'^snippets/(?P<pk>[0-9]+)/highlight/$', snippet_highlight, name='snippet-highlight'),
    #
    # url(r'^usersex/$', user_list, name='user-list'),
    # url(r'^usersex/(?P<pk>[0-9]+)/$', user_detail, name='user-detail'),

    #=============router url=================
    url(r'^', include(router.urls)),
    url(r'^$', views.api_root),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework')),

    url('^schema/$', schema_view),
]

#urlpatterns = format_suffix_patterns(urlpatterns)

# urlpatterns += [
#     url(r'^api-auth/', include('rest_framework.urls',
#                                namespace='rest_framework')),
# ]