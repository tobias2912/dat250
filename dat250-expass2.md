## Steps done in second assignment 
1. Followed steps to install derby
2. problem: Somehow enviroment variables were not stored or reset
3. problem: did not find the javax.persistence jar in the zip file
4. Using maven instead to add dependencies
5. Had to fix some version errors with maven
6. Error: cant find persistence provider. Tried to match project structure to the guide and add a <provider> attribute, but it changed nothing.
7. created classes to represent different entities with annotations in Exercise 2
8. still 'no persistence provided' error. Tried changing folder strucure, added META-INF and classes to classpath, adding a provider tag and referencing classes with package name, changing to a different provider. Different provider seems to work
9. Error: Arraylist is not embedable, so a Person cant have several cards. Solved with @elementCollection
10. error: jdbc.embeddeddriver not found. Tried adding more maven dependencies and it worked.
11. error: NoClassDefFoundError. cant find /derby/../JDBCboot. Tried changing derby dependencies with maven and adding derbytools or derbyclient, no changes. Few similar poblems on the web. Tried some other changes but this is as far as I came.


Both Experiments are in this repository.
