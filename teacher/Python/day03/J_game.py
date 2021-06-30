import turtle as t
import random as rd

def r(): t.setheading(0)
def u(): t.setheading(90)
def l(): t.setheading(180)
def d(): t.setheading(270)
def play():
    t.forward(10)
    te.forward(12)
    if rd.randint(1,5) == 3:
        angle = te.towards(t.pos())
        te.setheading(angle)
    if t.distance(tf) < 12:
        tfx = rd.randint(-230, 230)
        tfy = rd.randint(-230, 230)
        tf.goto(tfx, tfy)
    if t.distance(te) >= 12:
        t.ontimer(play, 100)
    
te = t.Turtle() # 적 
te.shape("turtle")
te.color("red")
te.speed(0)
te.up()
te.goto(0, 200)

tf = t.Turtle() # 먹이 
tf.shape("circle")
tf.color("green")
tf.speed(0)
tf.up()
tf.goto(0, -200)

t.bgcolor("orange")
t.shape("turtle")
t.color("white")
t.speed(0)
t.up()
t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")
t.listen()

play()

t.mainloop()