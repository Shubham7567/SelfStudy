# Strings in python are surrounded by either single or double quotation marks. Let's look at string formatting and some string methods

name = 'Shubham'
age = 22

#concatenate

print('hello, my name is ' + name + ' and my age is ' + str(age))

# String Formatting

#Arguments by position
print('Hello, My name is {name} and I am {age} years old'.format(name=name,age=age))

#F-Strings
print(f'Hello, My name is {name} and I am {age} years old')

# String Methods

s = 'hello world'

#capitalize string
print(s.capitalize())

#upper
print(s.upper())

#lower
print(s.lower())

#Swap case
print(s.swapcase())

#len
print(len(s))

#replce
print(s.replace('world','everyone'))

#Count
sub = 'h'
print(s.count(sub))

#starts with
print(s.startswith('hello'))

#ends with
print(s.endswith('world'))