import turtle as t

# turtle.shape("triangle")
t.shape("turtle")
t.pensize(3)

def m(n,len,col): #다각형을 그리는 메소드
    for x in range(n):
        t.color(col)
        t.forward(len)
        t.right(360/n)

t.begin_fill()
m(5,90,"GRAY")
t.end_fill()

t.circle(90)

t.exitonclick()