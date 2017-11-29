if [ $# -eq 2 ]; then
        SIZE=$1
        LEVEL=$2
        javac -cp ./aplu5.jar CurvaDiKoch.java
        java -cp .:aplu5.jar CurvaDiKoch $SIZE $LEVEL
fi
