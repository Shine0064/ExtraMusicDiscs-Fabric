set -e
while read -r p;
do
	s=$(echo "$p" | tr -d "\r")
	LINK=$(echo "$s" | sed -E "s/ .+//g")
	OUTFILE=$(echo "$s" | sed -E "s/.+ //g")
	echo "Starting download for: $LINK"
	./download_song.sh "$LINK" "$OUTFILE"
done <song_links.txt
screen -ls
