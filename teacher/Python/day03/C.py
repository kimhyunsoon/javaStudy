import turtle as t

t.speed(0)
t.bgcolor("black")
t.color("yellow")

for x in range(300):
    t.forward(x)
    t.left(89)

t.exitonclick()