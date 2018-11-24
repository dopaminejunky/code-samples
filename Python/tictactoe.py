# Roger Robertson
# Assignment 7: Tic-Tac-Toe
# Difficulty: Standard

import Gui3

# Window Area
CANVAS_WIDTH = 690
CANVAS_HEIGHT = 360

# Draw 2 boards that are 300 x 300 px
# 30 px in between boards
# Use 4 lines that are 3 px wide
# 2 vert lines and 2 horiz lines
# Lines divide board into 9 100 x 100 px squares
# Board is centered in canvas
def board(x, y, canvas):
    canvas.line([[x,y+50], [x+300,y+50]], width=3)
    canvas.line([[x,y-50], [x+300,y-50]], width=3)
    canvas.line([[x+200,y-150], [x+200, y+150]], width=3)
    canvas.line([[x+100,y-150], [x+100,y+150]], width=3)
    

# Pieces will be X's and O's
# 2 of each piece
# Pieces will be 80 x 80 px
# X is 2 lines, 7 px wide
# O is a circle, 7 px thick
# O is tangent to lines of box
def Xman(x, y, canvas):
    canvas.line([[x+40,y+40], [x-40, y-40]], width=7)
    canvas.line([[x+40,y-40], [x-40, y+40]], width=7)

def Oman(x, y, canvas):
    canvas.circle([x, y], 40, width=7)


# Main
def main():
    win = Gui3.Gui()
    win.title('Tic-Tac-Toe')
    canvas = win.ca(CANVAS_WIDTH, CANVAS_HEIGHT)
    board(15,0, canvas)
    board(-315,0, canvas)
    Xman(-65,100, canvas)
    Oman(-165, -100, canvas)
    Xman(65, 0, canvas)
    Oman(65, -100, canvas)
    Xman(-165, 0, canvas)
    Oman(-65, 0, canvas)
    Xman(165, 100, canvas)
    Oman(65, 100, canvas)
    win.mainloop()
main()
