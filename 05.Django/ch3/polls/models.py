from django.db import models

# Create your models here.

class Question(models.Model): #모델로부터 상속받은 모델?
    question_text = models.CharField(max_length=200) #멤버변수->컬럼명이 된다, CharField 데이터타입
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.question_text


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

    def __str__(self):
        return self.choice_text

