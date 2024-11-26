# java_katas

## Classic code katas in java
A simple directory where build & run my katas.

## Installation
openjdk 11.0.13 + junit-4.13.22 + json-201401072 (but, please, check-it, maybe I forgot to update this ;-) )


## Code katas

* [Alarm clock](#Alarm-clock)
* [Leap year](#Leap-year)
* [Remote calculator](#Remote-calculator)


Thanks to [cyber dojo](https://cyber-dojo.org/) for kata descriptions, and to be "_a place to practice programming_"

---
### Alarm clock
As a programmer I want to receive/build an Alarm object 
so I can check the timeout only when I need/want

Alarm class has a public constructor `Alarm(long n_sec)` where 
* `n_sec` is the number of seconds before the alarm “expires” 
* `public boolean isExpired()` method that returns
    * `false` from its creation to n_sec-1 from the object creation
    * `true` after n_sec from the object creation
      
Examples
* `Alarm(0).isExpired()` returns true
* `Alarm(100).isExpired()` has to return `false` after 99 sec. or less
* `Alarm(100).isExpired()` has to return `true` after 100 sec. or more
      
**Alarm has to be unit-testable**: remove the dependency from the time (hint: use dependency injection)

---
### Leap year
 
As a history professor    
I want to know what were the leap years    
so I can calculate the time exactly
   
(aka:   
write a _method_ that returns true or false depending on whether its input integer is a leap year or not.   
Year <0 is b.c, year >0 is a.d.)

Leap year definitions
* Before Julian calendar was applied (8 AD) no leap years were defined
* Julian calendar (from 8 to 1582): a leap year is defined as one that is divisible by 4    
 (_historical note: Julian calendar was introduced in 45 BC, but it was "full operational" only in 8 AD_)
* Gregorian calendar (from 1582): a leap year is defined as one that is divisible by 4, but is not otherwise divisible by 100 unless it is also divisible by 400.

Examples:
* +8 was the first leap year in history
* 1100 was a leap year
* 1584 was the first leap year of the Gregorian calendar
* 1900 is an atypical common year
* 2000 is an atypical leap year

---
### Remote calculator
Given a json `{ "Cmd": "add", "val1": -12, “val2”: 42 }`
define a function (method) that performs the command
(in this case has to return 30 )

The possible commands are
* `{ "Cmd": "add", "val1": 3, “val2”: 2 }` expected result = 5
* `{ "Cmd": "sub", "val1": 3, “val2”: 2 }` expected result = 1
* `{ "Cmd": "mul", "val1": 3, “val2”: 2 }` expected result = 6
* `{ "Cmd": "div", "val1": 1, “val2”: 2 }` expected result = 0.5

