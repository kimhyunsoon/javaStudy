import turtle as t
import random as r

t.shape("turtle")
t.color("gray")
# t.speed(0)

for x in range(200):
    a = r.randint(1,360)
    t.setheading(a)
    d = r.randint(1,100)
    t.forward(d)



t.exitonclick()