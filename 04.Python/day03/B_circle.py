import turtle as t

# turtle.shape("triangle")


t.speed(0)
t.bgcolor("black")

def m(n,radius,fCol):
    t.color(fCol)

    for x in range(n):
        t.circle(radius)
        t.left(360/n)

m(50,30,"green")
m(30,60,"yellow")
t.exitonclick()