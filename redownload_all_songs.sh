set -e
while read -r p;
do
	s=$(echo "$p" | tr -d "\r")
	LINK=$(echo "$s" | cut -d " " -f 1)
	OUTFILE=$(echo "$s" | cut -d " " -f 2)
	echo "Starting download for: $LINK"
	screen -AmdS "$OUTFILE" ./download_song.sh "$LINK" "$OUTFILE"
	sleep 2
done < song_links.txt
screen -ls
