"""
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


from django.urls import path
from polls import views


app_name = 'polls'
urlpatterns = [

    #path(route: str, view: (*args: Any, **kwargs: Any) -> HttpResponseBase, kwargs: Dict[str, Any] = ..., name: str = ...) -> URLPattern
    #kwargs :  keyword argument

    # /polls/
    path('', views.IndexView.as_view(), name='index'),

    # /polls/99/
    path('<int:pk>/', views.DetailView.as_view(), name='detail'),

    # /polls/99/results/
    path('<int:pk>/results/', views.ResultsView.as_view(), name='results'),

    # /polls/99/vote/
    path('<int:question_id>/vote/', views.vote, name='vote'),
]