from turtle import Turtle, Screen


planets = {
    'venus': {'diameter': 0.949, 'orbit': 150, 'speed': 6.1518496616072005, 'color': 'yellow'},
    'earth': {'diameter': 1.0, 'orbit': 208.33333333333334, 'speed': 10, 'color': 'blue'},
}

line = Turtle();
line.ht();
line.speed(0)
line.pencolor("#bbb")

def setup_planets(planets):
    for planet in planets:
        dictionary = planets[planet]

        turtle = Turtle(shape='circle')

        turtle.speed("fastest")
        turtle.shapesize(dictionary['diameter'])
        turtle.color(dictionary['color'])
        turtle.penup()
        turtle.sety(-dictionary['orbit'])
        turtle.pendown()
    

        dictionary['turtle'] = turtle

    screen.ontimer(revolve, 0)


def revolve():
    earthD = planets['earth']
    venusD = planets["venus"]
    earthD['turtle'].circle(earthD['orbit'], earthD['speed'])
    venusD['turtle'].circle(venusD['orbit'], venusD['speed'])
    
    line.penup();
    line.setpos(earthD['turtle'].pos())
    line.pendown();
    line.setpos(venusD['turtle'].pos())        

    screen.ontimer(revolve, 0)

screen = Screen()
screen.title("Earth and Venus's orbital cycle");
screen.bgcolor("black")
setup_planets(planets)

screen.exitonclick()
