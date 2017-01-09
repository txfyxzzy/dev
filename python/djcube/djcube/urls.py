"""djcube URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.8/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import include, url
from django.contrib import admin

from djcube.views import hello, time_1, time_2, hours_ahead
from books import views

admin.autodiscover()

urlpatterns = [
    url(r'^polls/', include('polls.urls')),
    url(r'^snippets/', include('snippets.urls')),
    url(r'^admin/', include(admin.site.urls)),

    url(r'^hello/$', hello),
    url(r'^time1/$', time_1),
    url(r'^time2/$', time_2),
    url(r'^time/plus/(\d{1,2})/$', hours_ahead),

    url(r'^meta/$', views.display_meta),
    url(r'^search/$', views.search_form),
    url(r'^contact/$', views.contact_2),
]
