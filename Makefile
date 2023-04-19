JAVAC = /usr/bin/javac
JAVA = /usr/bin/java
JAVADOC = /usr/bin/javadoc

.SUFFIXES: .java .class
SRCDIR = src
BINDIR = bin
DOCSDIR = doc

build:
	@echo "Compiling application"
	@mkdir -p $(BINDIR)
	@$(JAVAC) -d $(BINDIR)/ ${SRCDIR}/*.java

gen-test-data:
	@echo "Generating test data"
	@python3 makedataset.py > "dataset.txt"

clean:
	@echo "Cleaning bin/docs directory"
	@rm -rf $(BINDIR)/
	@rm -rf ${DOCSDIR}/

run: 
	@echo "Compiling and running application"
	@mkdir -p $(BINDIR)
	@$(JAVAC) -d $(BINDIR)/ ${SRCDIR}/*.java
	@$(JAVA) -cp bin Program

doc:
	@echo "Generating javadocs"
	@mkdir -p $(DOCSDIR)
	@$(JAVADOC) -d $(DOCSDIR)/ ${SRCDIR}/*.java