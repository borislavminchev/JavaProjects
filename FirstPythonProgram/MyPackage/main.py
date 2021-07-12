class Animal:
    def __init__(self, legs, speed):
        self.legs = legs
        self.speed = speed

    def make_sound(self):
        print("grrrrr")


class Cat(Animal):

    def __init__(self, legs, speed, name):
        super.__init__(legs, speed)
        self.name = name

    def make_sound(self):
        print("Mewwww")


a = Animal(4, 25.0)

for i in range(5, 10):
    print(i)
