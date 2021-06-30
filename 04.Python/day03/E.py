import turtle as t
import random as r


t.bgcolor("black")
t.speed(0)

for x in range(300):
    if x%3 ==0:
        t.color("yellow")
    if x%3 ==1:
        t.color("white")
    if x%3 ==2:
        t.color("green")

    t.forward(x)
    t.left(119)




t.exitonclick()