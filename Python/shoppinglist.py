# Roger Robertson
# Assignment 8: Shopping List
# Difficulty: Standard

# create a shared list
theList = []

# Menu commands
def printMenu():
    print('Here are the list of commands:')
    print('-p : Print the list')
    print('-e : Empty the list')
    print('-r : Remove single item from list')
    print('-x : Exit')
    print('-h : Print this command list')

# Add an item to the shared list
# Do not allow duplicates
def addToList(item):
    if item not in theList:
        theList.append(item)
        print('You have added ' + item + ' to the list.')
    else:
        print('You already added that item!')
    
# Get user input for list items
# Do not allow blank items
def getInput():
    print('You have ' + str(len(theList)) + ' items on your list.')
    item = input('Enter an item or command: ')
    while item == '' or item.isspace():
        print('Shopping list items cannot be blank.')
        item = input('Enter an item or command: ')
    return item
    
# Print list command
# Complicated, numbered list
# For humans, not computers
def printList():
    print('Your shopping list:')
    for item in theList:
        print(str(theList.index(item)+1)+'.', item)

# Remove single item command
# Can be reference number or the actual item
def delItem(num):
    if num in theList:
        theList.remove(num)
        print(num, 'removed from the list.')
    elif int(num) in range(len(theList)):
        del theList[int(num)-1]
        print('Item', num, 'removed from the list.')
        
# Empty list command
def emptyList():
    del theList[0:len(theList)]
    print('List emptied!')
    
# Welcome message
def startProgram():
    print('Welcome to the XYZ Shopping List Program')

# Goodbye message
def endProgram():
    print('Thank you for using the XYZ Shopping List Program.')

# main
def main():
    startProgram()
    printMenu()
    item = getInput()
    while item != '-x':
        if item == '-p':
            printList()
        elif item == '-h':
            printMenu()
        elif item == '-e':
            emptyList()
        elif '-r' in item:
            delItem(item.strip('-r '))
        else:
            addToList(item)
        item = getInput()
    endProgram()

main()
