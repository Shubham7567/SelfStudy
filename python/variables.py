# A variable is a container for a value, which can be of various types

'''
This is a multiline comment
or docstring (used to define a function's perpouse)
can be single or double quotes
'''

"""
VARIABLE RULES:
    - Variable names must be in small letter with underscore if name contain more than one word or you can use camelcase
    - Must start with a letter or underscore
    - Can have numbers but can not start with number
"""

x = 1  #int
y = 2.5 #float
name = 'Shubham' #str
is_cool = True #bool with this you must have True not true and False not false

print(x , y ,name , is_cool)#to print all the variable values

#multiple assignment to do less and effective code
x,y,name,is_cool = (1,2.5,'Shubham',True)

print(x , y ,name , is_cool)#to print all the variable values

a = x + y#addition
print(a)

print(type(x),type(y))# to display type class of variable 

x = str(x)#type casting
y = int(y)
print(type(x))
print(type(y),y)

z = float(y)
print(type(z),z)
