import turtle as t

t.screensize(500, 500)
t.speed(1)
t.shape("turtle")
t.colormode(255)


def drawRound(size, filled):
    t.pendown()
    if filled == True:
        t.begin_fill()
    t.setheading(180)
    t.circle(size, 360)
    if filled == True:
        t.end_fill()


def head():
    t.color("blue", "blue")
    t.penup()
    t.goto(0, 100)
    drawRound(75, True)

    t.color("white", "white")
    t.penup()
    t.goto(0, 72)
    drawRound(60, True)


def eyes():
    t.color("black", "white")
    t.penup()
    t.goto(-15, 80)
    drawRound(17, True)

    t.color("black", "white")
    t.penup()
    t.goto(19, 80)
    drawRound(17, True)

    t.color("black", "black")
    t.penup()
    t.goto(-8, 70)
    drawRound(6, True)
    t.color("white", "white")
    t.penup()
    t.goto(-8, 66)
    drawRound(2, True)

    t.color("black", "black")
    t.penup()
    t.goto(12, 70)
    drawRound(6, True)
    t.color("white", "white")
    t.penup()
    t.goto(12, 66)
    drawRound(2, True)


def nose():
    t.color("red", "red")
    t.penup()
    t.goto(0, 40)
    drawRound(7, True)
    t.begin_fill()


def mouth():
    t.color("black", "black")
    t.penup()
    t.goto(-30, -20)
    t.pendown()
    t.setheading(-27)
    t.circle(70,55)

    t.penup()
    t.goto(0, 26)
    t.pendown()
    t.goto(0, -25)

def whisker():
    t.color("black", "black")
    t.penup()
    t.goto(6, 35)
    t.pendown()
    t.forward(100)

    t.penup()
    t.goto(6, 35)
    t.rt(20)
    t.pendown()
    t.forward(100)

    t.penup()
    t.goto(6, 35)
    t.rt(20)
    t.pendown()
    t.forward(100)

    t.penup()
    t.goto(-6, 35)
    t.rt(200)
    t.pendown()
    t.forward(100)

    t.penup()
    t.goto(-6, 35)
    t.lt(20)
    t.pendown()
    t.forward(100)

    t.penup()
    t.goto(-6, 35)
    t.lt(20)
    t.pendown()
    t.forward(100)


head()
eyes()
nose()
mouth()
whisker()
