set -e
LINK=$1
OUTFILE=$2
yt-dlp -f bestaudio -o "in.webm" "$LINK"
ffmpeg -i 'in.webm' -ac 1 -af "loudnorm" -y -vn -c:a libvorbis -ar 44100 "$OUTFILE.ogg"
mv "$OUTFILE.ogg" "./src/main/resources/assets/extramusicdiscs/sounds/records/"
rm "in.webm"
#ffprobe -show_entries format=duration -v quiet -of csv="p=0" "$OUTFILE.ogg"
#sleep 60