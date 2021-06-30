import turtle as t

def r():
    t.setheading(0)
    t.forward(10)
def u():
    t.setheading(90)
    t.forward(10)
def l():
    t.setheading(180)
    t.forward(10)
def d():
    t.setheading(270)
    t.forward(10)

def pUp(): t.penup()
def pDown(): t.pendown()

def init(): t.clear()

def red(): t.color("Red")
def green(): t.color("Green")
def blue(): t.color("Blue")
def yellow(): t.color("Yellow")
def black(): t.color("Black")

t.shape("turtle")
t.speed(0)

t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")

t.onkeypress(pUp, "u")
t.onkeypress(pDown, "d")

t.onkeypress(init, "Escape")

t.onkeypress(red, "r")
t.onkeypress(green, "g")
t.onkeypress(blue, "b")
t.onkeypress(yellow, "y")
t.onkeypress(black, "k")

t.listen()
t.exitonclick()