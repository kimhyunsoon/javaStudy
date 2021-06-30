import turtle as t

def penUp():
    t.penup()
def penDown():
    t.pendown()


t.onkeypress(penUp, "u")
t.onkeypress(penDown, "d")
t.onscreenclick(t.goto)
t.listen()

t.mainloop()