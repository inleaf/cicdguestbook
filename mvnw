#!/bin/sh
# ----------------------------------------------------------------------------
# Maven Wrapper Bootstrap Script
#
# This script allows you to run Maven without requiring it to be pre-installed.
# ----------------------------------------------------------------------------

# Resolve the location of the script
PRG="$0"
while [ -h "$PRG" ]; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`"/$link"
  fi
done

# Get standard environment variables
PRGDIR=`dirname "$PRG"`
BASEDIR=`cd "$PRGDIR" >/dev/null; pwd`

# Check for MAVEN_OPTS
if [ -z "$MAVEN_OPTS" ] ; then
  MAVEN_OPTS="-Xmx1024m"
fi

# Check if wrapper jar exists
WRAPPER_JAR="$BASEDIR/.mvn/wrapper/maven-wrapper.jar"
if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Downloading Maven Wrapper..."
  mkdir -p "$BASEDIR/.mvn/wrapper"
  curl -o "$WRAPPER_JAR" https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar
fi

# Run Maven with the wrapper
JAVA_CMD="java"
exec "$JAVA_CMD" \
  $MAVEN_OPTS \
  -classpath "$WRAPPER_JAR" \
  -Dmaven.multiModuleProjectDirectory="$BASEDIR" \
  org.apache.maven.wrapper.MavenWrapperMain "$@"
