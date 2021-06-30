import turtle as t

def pUp(): t.penup()
def pDown(): t.pendown()
def init(): t.clear()
t.onkeypress(pUp, "u")
t.onkeypress(pDown, "d")
t.onkeypress(init, "Escape")

t.onscreenclick(t.goto)
t.listen()

t.mainloop()