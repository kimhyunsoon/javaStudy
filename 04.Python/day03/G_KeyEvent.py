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

def penUp():
    t.penup()
def penDown():
    t.pendown()

def init():
    t.clear()

def grey(): t.color("Grey")
def green(): t.color("Green")
def blue(): t.color("Blue")
def yellow(): t.color("Yellow")

t.shape("turtle");
t.speed(10)

t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")

t.onkeypress(penUp, "u")
t.onkeypress(penDown, "d")

t.onkeypress(init, "Escape")

t.listen()
t.done()