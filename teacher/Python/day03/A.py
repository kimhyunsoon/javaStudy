import turtle as t

#t.shape("circle")
#t.shape("square")
t.shape("turtle")
t.pensize(1)

def m(n, len, col): # 다각형을 그리는 메소드
    for x in range(n):
        t.color(col)
        t.forward(len)
        t.right(360/n)

t.begin_fill()
m(4, 50, "red")
t.end_fill()

m(5, 70, "green")
m(6, 90, "blue")

t.circle(90) #반지름을 90으로 갖는 원 

t.exitonclick()