from django.contrib import admin
from polls.models import Question, Choice



#5. admin.TabularInline : 표의 형태
class ChoiceInline(admin.TabularInline):
    model = Choice
    extra = 2 


#4. admin.StackedInline : 한줄씩 쌓는 형태
#class ChoiceInline(admin.StackedInline):
#    model = Choice
#    extra = 2 

class QuestionAdmin(admin.ModelAdmin):
    #1. 순서 변경
    #fields = ['pub_date', 'question_text'] 
    
    #2. 필드 분리
    fieldsets = [
        ('Question Statement', {'fields' : ['question_text']}),
        #('Date Information', {'fields' : ['pub_date']}),

        #3. collapse : Show and Hide
        ('Date Information', {'fields' : ['pub_date'], 'classes' : ['collapse']}),
    ]

    
    inlines = [ChoiceInline]
    list_display = ('question_text', 'pub_date') #list에서 질문내용과 날짜가 같이 보여지게
    list_filter = ['pub_date'] #list의 속성 가지고 필터링하기
    search_fields = ['question_text'] #검색 추가

admin.site.register(Question, QuestionAdmin) #새로운 클래스를 생성하여 맵핑하는 방식
admin.site.register(Choice)
