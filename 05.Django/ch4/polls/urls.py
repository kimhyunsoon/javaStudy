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

    path('', views.index, name='index'),      # /polls/ #views.index에 정의된 놈을 호출
    path('<int:question_id>/', views.detail, name='detail'),       # /polls/2/
    path('<int:question_id>/results/', views.results, name='results'),     # /polls/2/results/ 
    path('<int:question_id>/vote/', views.vote, name='vote'),      # /polls/2/vote/
]