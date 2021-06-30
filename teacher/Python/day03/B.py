import turtle as t

t.speed(0)
t.bgcolor("black")

def m(n, radius, fCol): #n:반복수, radius:반지름, fCol:포그라운드컬러
    t.color(fCol)
    for x in range(n):
        t.circle(radius)
        t.left(360/n)

m(50, 30, "green")
m(30, 60, "yellow")

t.exitonclick()