JAVAC = /usr/bin/javac
JAVA = /usr/bin/java
.SUFFIXES: .java .class
SRCDIR = src
BINDIR = bin

build:
	@echo "Compiling application"
	@mkdir -p $(BINDIR)
	@$(JAVAC) -d $(BINDIR)/ ${SRCDIR}/*.java

gen-test-data:
	@echo "Generating test data"
	@python3 makedataset.py > "dataset.txt"

clean:
	@echo "Cleaning bin directory"
	@rm -rf $(BINDIR)/

run: 
	@echo "Compiling and running application"
	@mkdir -p $(BINDIR)
	@$(JAVAC) -d $(BINDIR)/ ${SRCDIR}/*.java
	@$(JAVA) -cp bin Program