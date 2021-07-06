from django.contrib import admin
from polls.models import Question, Choice
# Register your models here.
admin.site.register(Question)
admin.site.register(Choice)

#어떻게 나오나?