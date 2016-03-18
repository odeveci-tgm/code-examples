CXX            	= /usr/bin/g++
CPPFLAGS      	= -g -c
LDFLAGS       	= -g
OMNI_HOME     	= /home/schueler/omniORB-4.1.7/build
OMNIIDL       	= $(OMNI_HOME)/bin/omniidl
LIBS          	= -lomniORB4 -lomnithread -lomniDynamic4
OBJECTS       	= echoSK.o server.o
IDL_DIR		= ../idl
IDL_FILE	= $(IDL_DIR)/echo.idl

all server: $(OBJECTS)
	$(CXX) $(LDFLAGS) -o server server.o echoSK.o $(LIBS)

server.o: server.cc
	$(CXX) $(CPPFLAGS) server.cc -I.

echoSK.o: echoSK.cc echo.hh
	$(CXX) $(CPPFLAGS) echoSK.cc -I.

echoSK.cc: $(IDL_FILE)
	$(OMNIIDL) -bcxx $(IDL_FILE)

clean clean-up:
	rm -rf *.o
	rm -rf *.hh
	rm -rf *SK.cc
	rm -rf server
