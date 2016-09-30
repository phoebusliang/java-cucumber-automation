Cucumber Gradle Parallel Example
===============================

Clone the repository:

    $ git clone git@github.com:camiloribeiro/cucumber-gradle-parallel.git

Run in sequence, the usual way:

    $ gradle clean build runInSequence

Check the total time in the output. Now, run it in parallel:

    $ gradle clean build runInParallel