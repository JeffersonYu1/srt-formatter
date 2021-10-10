# SRT Formatter
Java program that formats single-line captions into proper SRT (SubRip Subtitle) files. Written by Jefferson Yu.

## About the Project
### Motivation
According to [docs.fileformat.com](https://docs.fileformat.com/video/srt/), each subtitle entry in an SRT should be formatted with the following items: 
1. A numeric counter indicating the number or position of the subtitle.
2. Start and end time of the subtitle separated by --> characters
3. Subtitle text in one or more lines.
4. A blank line indicating the end of the subtitle.

For example:
```
1
00:05:00,400 --> 00:05:15,300
This is an example of
a subtitle.

2
00:05:16,400 --> 00:05:25,300
This is an example of
a subtitle - 2nd subtitle.
```

Unfortunately, a large chunk of subtitles export incorrectly as single lines. For example, the following subtitles were exported from one of my middle school Spanish projects:
```
1 00:00:06,080 --> 00:00:06,780 ¡Buenas tardes! 2 00:00:06,780 --> 00:00:07,560 Buenas tardes. 3 00:00:07,920 --> 00:00:10,480 Yo necesito una mesa y un menu. 4 00:00:10,900 --> 00:00:13,340 ¡Si! ¿Usted tiene una reservación? 5 00:00:13,888 --> 00:00:15,888 No, no tengo una reservación. 6 00:00:15,888 --> 00:00:16,923 Si. 7 00:00:18,260 --> 00:00:21,920 Yo necesito una mesa para una persona. 8 00:00:24,724 --> 00:00:26,724 Sientense por favor. 9 00:00:26,724 --> 00:00:27,693 Soy el camarero. 10 00:00:29,360 --> 00:00:31,660 ¿Tiene usted hambre o sed? 11 00:00:31,680 --> 00:00:33,940 Si, yo tengo hambre y sed. 12 00:00:37,080 --> 00:00:39,080 Aquí es el menu. 13 00:00:43,320 --> 00:00:47,400

...
etc.
```

Without the proper line breaks, the file is unreadable as a subtitle track by video players. 

### Features
The SRT Formatter program takes the above, unformatted text...

and transforms it into the following: 
```
1
00:00:06,080 --> 00:00:06,780
¡Buenas tardes!

2
00:00:06,780 --> 00:00:07,560
Buenas tardes.

3
00:00:07,920 --> 00:00:10,480
Yo necesito una mesa y un menu.

4
00:00:10,900 --> 00:00:13,340
¡Si! ¿Usted tiene una reservación?

...
etc.
```

### Samples
Samples can be found under `\src\test\resources\`. 

## Contact
* Jefferson Yu - [fu.yao.yu at hotmail dot com](mailto:fu.yao.yu@hotmail.com)
