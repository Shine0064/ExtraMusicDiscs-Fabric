set -e
LINK=$1
OUTFILE=$2
INTERMEDIATE="$OUTFILE.in"
yt-dlp -f bestaudio -o "$INTERMEDIATE.webm" "$LINK"
ffmpeg.exe -nostdin -i "$INTERMEDIATE.webm" -ac 1 -af "loudnorm" -y -vn -c:a libvorbis -b:a 64k -ar 44100 "$OUTFILE.ogg"
ffprobe -show_entries format=duration -v quiet -of csv="p=0" "$OUTFILE.ogg"
mv "$OUTFILE.ogg" "./src/main/resources/assets/extramusicdiscs/sounds/records/"
rm "$INTERMEDIATE.webm"