from django.shortcuts import get_object_or_404, render
from django.http import HttpResponseRedirect
from django.urls import reverse

from polls.models import Choice, Question #polls 밑에 models 밑에 Question과 Choice

# /polls 페이지에서 가장 먼저 보여지는 view
def index(request): 
    latest_question_list = Question.objects.all().order_by('-pub_date')[:5] #객체 중 모든 것을 갖고 와라, list 형태니까 처음부터 5개까지 보여주게
    context = {'latest_question_list': latest_question_list} #dict 형
    return render(request, 'polls/index.html', context)  # polls/index.html이 템플릿
    #render : 전달 된 인수로 django.template.loader.render_to_string ()을 호출 한 결과로 내용이 채워진 HttpResponse를 반환합니다.
    # render( request: HttpRequest, template_name: str, context: Mapping[str, Any])


def detail(request, question_id): #요청 객체와 question_id값을 파라미터변수로 받는다
    # question_id 값은 int의 형태로 질문이 생성된 순서대로 0,1,2 번호를 부여받는다
    question = get_object_or_404(Question, pk=question_id)
    # get_object_or_404: get ()을 사용하여 객체를 반환하거나 객체가없는 경우 Http404 예외를 발생시킵니다.
    context = {'question': question}
    return render(request, 'polls/detail.html', context)

def results(request, question_id):
    question = get_object_or_404(Question, pk=question_id) 
    context = {'question': question}
    return render(request, 'polls/results.html',context)

def vote(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    try:
        selected_choice = question.choice_set.get(pk=request.POST['choice']) #detail.html에서 POST방식으로 넘겨줄 때 'choice'로 넘어온 값을 받아서 변수에 저장
    except (KeyError, Choice.DoesNotExist):
        # Redisplay the question voting form.
        return render(request, 'polls/detail.html', {
            'question': question,
            'error_message': "You didn't select a choice.",
        })
    else:
        selected_choice.votes += 1
        selected_choice.save()
        # Always return an HttpResponseRedirect after successfully dealing
        # with POST data. This prevents data from being posted twice if a
        # user hits the Back button.
        return HttpResponseRedirect(reverse('polls:results', args=(question.id,)))

