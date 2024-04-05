JAVAC = javac
JAVA = java

BUILD_DIR = build
MAIN_CLASS = Main
CLASSPATH = $(shell pwd)/bin

JAVA_FILES := $(wildcard *.java)
CLASS_FILES := $(addprefix $(BUILD_DIR)/,$(JAVA_FILES:%.java=%.class))

all: $(CLASS_FILES)

$(BUILD_DIR)/%.class: %.java
	$(JAVAC) $(JFLAGS) -d $(BUILD_DIR) $<
	
run:
	$(JAVA) -classpath $(BUILD_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BUILD_DIR)/*.class

rebuild: clean all

.PHONY: all run clean rebuild