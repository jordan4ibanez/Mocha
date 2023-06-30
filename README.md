# Mocha
### An IDE for Java written in Java.

Project goals:


0. Bootstrap off of IntelliJ. (the most basic goal, write the IDE in the IDE)
1. Get a text editor running.
2. Auto save and whatnot.
   - Automatically saves X seconds after typing.
3. Get a file browser running.
4. Get tabs running.
5. Utilize gradle.
   - ``gradle build`` can be used for getting errors.
   - OR ``gradle build -t`` for continuous checks.
      - A listener could listen to this for errors or success.
6. Some kind of cache for classes and methods. Maybe reflection can be used to index?
7. Git integration could be cool, but that's a pipe dream at this point.