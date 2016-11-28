from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from django.conf.urls import include
from snippets import views

urlpatterns = [
    url(r'^snippets/$', views.snippet_list),
    url(r'^snippets/(?P<pk>[0-9]+)/$', views.snippet_detail),
    url(r'^snippetsapifun/$', views.snippet_list_ex),
    url(r'^snippetsapifun/(?P<pk>[0-9]+)/$', views.snippet_detail_ex),
    url(r'^snippetsapicls/$', views.SnippetList.as_view()),
    url(r'^snippetsapicls/(?P<pk>[0-9]+)/$', views.SnippetDetail.as_view()),

    url(r'^snippetsapiclsex/$', views.SnippetListEx.as_view()),
    url(r'^snippetsapiclsex/(?P<pk>[0-9]+)/$', views.SnippetDetailEx.as_view()),
    url(r'^snippetsapiclsexex/$', views.SnippetListExEx.as_view()),
    url(r'^snippetsapiclsexex/(?P<pk>[0-9]+)/$', views.SnippetDetailExEx.as_view()),

    url(r'^usersex/$', views.UserList.as_view()),
    url(r'^usersex/(?P<pk>[0-9]+)/$', views.UserDetail.as_view()),
]

urlpatterns = format_suffix_patterns(urlpatterns)

urlpatterns += [
    url(r'^api-auth/', include('rest_framework.urls',
                               namespace='rest_framework')),
]