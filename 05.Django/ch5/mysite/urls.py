"""mysite URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from django.urls.conf import include
from mysite import views

urlpatterns = [
    #default
    path('admin/', admin.site.urls),
    # by kaeun
    path('polls/', include ('polls.urls')), #include는 polls.py의 urlpatterns를 다 가져오는 것과 같다
    path('books/', include('books.urls')),
    
    path('', views.HomeView.as_view(), name = 'home'),
]