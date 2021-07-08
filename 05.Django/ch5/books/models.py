from django.db import models

#변수들이 컬럼명이 된다
class Book(models.Model):
    title = models.CharField(max_length=100)
    authors = models.ManyToManyField('Author') #다대 다 관계이기 때문에(공동저자)
    publisher = models.ForeignKey('Publisher', on_delete=models.CASCADE)
    publication_date = models.DateField()

    def __str__(self):
        return self.title


class Author(models.Model):
    name = models.CharField(max_length=50)
    salutation = models.CharField(max_length=100)
    email = models.EmailField()

    def __str__(self):
        return self.name


class Publisher(models.Model):
    name = models.CharField(max_length=50)
    address = models.CharField(max_length=100)
    website = models.URLField()

    def __str__(self):
        return self.name
