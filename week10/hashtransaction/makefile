JFLAGS =
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java


default: classes

CLASSES = $(wildcard *.java)

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

