from spike import PrimeHub, LightMatrix, Button, StatusLight, ForceSensor, MotionSensor, Speaker, ColorSensor, App, DistanceSensor, Motor, MotorPair
from spike.control import wait_for_seconds, wait_until, Timer
from math import *

hub = PrimeHub()

hub.light_matrix.show_image('SURPRISED')
hub.light_matrix.write('Hello!')
#pair = MotorPair('E', 'F')

#pair.move(20, 'cm', 0, 30)

#wait_for_seconds(3)

#pair.move(20, 'cm', 0, -30)

pair = MotorPair('E', 'F')
pair.move_tank(20, 'cm', 30, 30)
wait_for_seconds(3)
pair.move_tank(20, 'cm', -30, -30)
pair = MotorPair('E', 'F')
pair.start(speed=50)
wait_for_seconds(3)
pair.stop()
pair = MotorPair('E', 'F')
pair.move_tank(720, 'degrees', 30, -30)
wait_for_seconds(3)
pair.move_tank(2, 'rotations', -30, 30)
720도에 2바퀴
Swing turn
pair = MotorPair('E', 'F')
pair.move_tank(720, 'degrees', 30, 0) 오른쪽으로 돔
wait_for_seconds(3)
pair.move_tank(2, 'rotations', 0, 30) 왼쪽으로 돔
#Curve Turn
pair = MotorPair('E', 'F')
pair.move_tank(5, 'seconds', 50, 30)
90도만 돌리기
from spike import MotorPair
pair = MotorPair('E', 'F')
pair.move(20)
pair.move_tank(180, 'degrees', 30, -30)
pair.move(20)
motor = Motor('C')
motor.run_to_position(0) #모터의 절대위치는 0
단일 모터 동작 함수 중에
rotations 보단 degrees 를 추천
rotations 은 1바퀴 설정하면 본체와 충돌
get_speed() 모터의 회전 속도를 가져옵니다.
get_position() 모터의 절대 위치를 가져옵니다
set_defalut_speed() 기본 모터 속도를 설정
from spike import Motor
motor = Motor('C')
motor.run_to_position(150)
motor.run_for_degrees(170)
light_matrix, speaker
#PrimeHub 객체를 생성해서 사용합니다.
hub = PrimeHub()
hub.light_matrix.show_image('RABBIT')
hub. speaker.beep(67, 0.5)
while(반복 조건) : << 콜론 필수
( 들여쓰기 ) THEN절
for count in range(10) : << range 안에 반복횟수입력
hub = PrimeHub()
hub.speaker.beep(72, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
hub.speaker.beep(72, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
hub.speaker.beep(72, 0.2)
hub.speaker.beep(63, 0.2)
hub.speaker.beep(64, 0.2)
hub.speaker.beep(65, 0.2)
hub.speaker.beep(66, 0.2)
hub.speaker.beep(67, 0.2)
hub.speaker.beep(68, 0.2)
hub.speaker.beep(69, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
wait_for_seconds(0.5)
#도 60 레 61 62 63 64 65 66 도67 68 69 70 71 72---
from spike import ColorSensor
color_sensor = ColorSensor('A')
wait_for_seconds(0.5) #컬러센서가 측정할 시간이 필요 최소가 0.5
# 색상을 측정합니다.
color = color_sensor.get_color()
# 콘솔에 색상 이름을 표시합니다
print('Detected:', color)
#컬러센서는 조건문 if 많이 사용
# if ( ) :
# (then절)
from spike import ColorSensor, MotorPair
color = ColorSensor('A')
pair = MotorPair('E', 'F')
while True:
if color.get_color() == 'black':
pair.start_tank(35, 20)
else :
pair.start_tank(20, 35)
#최소거리 4cm 최대거리 200cm

from spike import DistanceSensor, MotorPair
# dist_sensor = DistanceSensor('B')
# wait_for_seconds(0.5)
# dist = dist_sensor.get_distance_cm()
# print('dist_cm:' , dist)
dist_sensor = DistanceSensor('B')
pair = MotorPair('E', 'F')
while True :
dist = dist_sensor.get_distance_cm()
if dist != None :
if dist < 20:
pair.stop()
# hub.speaker.beep(72, 0.2)
# hub.speaker.beep(70, 0.2)
# hub.speaker.beep(71, 0.2)
# hub.speaker.beep(72, 0.2)
# hub.speaker.beep(70, 0.2)
# hub.speaker.beep(71, 0.2)
# hub.speaker.beep(72, 0.2)
# hub.speaker.beep(63, 0.2)
# hub.speaker.beep(64, 0.2)
# hub.speaker.beep(65, 0.2)
# hub.speaker.beep(66, 0.2)
# hub.speaker.beep(67, 0.2)
# hub.speaker.beep(68, 0.2)
# hub.speaker.beep(69, 0.2)
# hub.speaker.beep(70, 0.2)
# hub.speaker.beep(71, 0.2)
else :
pair.start(0, 30)
from spike import ColorSensor, PrimeHub
hub = PrimeHub()
color_sensor = ColorSensor('A')
while true :
if color_sensor.get_color() == 'green'
hub.speaker.beep(72, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
hub.speaker.beep(72, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
hub.speaker.beep(72, 0.2)
hub.speaker.beep(63, 0.2)
hub.speaker.beep(64, 0.2)
hub.speaker.beep(65, 0.2)
hub.speaker.beep(66, 0.2)
hub.speaker.beep(67, 0.2)
hub.speaker.beep(68, 0.2)
hub.speaker.beep(69, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
elif color_sensor.get_color() == 'red'
stop()
from spike import ColorSensor, PrimeHub, MotorPair
pair = MotorPair('E', 'F')
color_sensor = ColorSensor('A')
hub = PrimeHub()
while True :
if color_sensor.get_color() == 'green':
hub.light_matrix.write('G')
hub.speaker.beep(72, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
hub.speaker.beep(72, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
hub.speaker.beep(72, 0.2)
hub.speaker.beep(63, 0.2)
hub.speaker.beep(64, 0.2)
hub.speaker.beep(65, 0.2)
hub.speaker.beep(66, 0.2)
hub.speaker.beep(67, 0.2)
hub.speaker.beep(68, 0.2)
hub.speaker.beep(69, 0.2)
hub.speaker.beep(70, 0.2)
hub.speaker.beep(71, 0.2)
pair.start(0, 20)
elif color_sensor.get_color() == 'red':
hub.light_matrix.write('R')
hub.speaker.beep(75)
pair.stop()
else :
hub.light_matrix.write('X')
# color_sensor.wait_for_new_color()
from spike import MotorPair
from spike.control import wait_for_seconds
#2번

motor = Motor('C')
pair = MotorPair('E', 'F')
pair.move_tank(91, 'cm', 30, 30) #91
wait_for_seconds(1)
pair.move_tank(180, 'degrees', -30, 30)
wait_for_seconds(1)
pair.move_tank(42, 'cm', 30, 30) #50
wait_for_seconds(1)
motor.run_for_degrees(-130)
pair.move_tank(42, 'cm', -30, -30)
wait_for_seconds(1)
pair.move_tank(180, 'degrees', -30, 30)
wait_for_seconds(1)
pair.move_tank(91, 'cm', 30, 30)
#1번

from spike import Motor, MotorPair
pair = MotorPair('E', 'F')
motor = Motor('C')
motor.set_default_speed(100)
motor.run_for_degrees(-130)
pair = MotorPair('E', 'F')
pair.move_tank(77, 'cm', 30, 30)
motor.run_for_degrees(130)
wait_for_seconds(1)
pair.move_tank(5, 'cm', -30, -30)
motor.run_for_degrees(-130)
pair.move_tank(5, 'cm', -30, -30)
pair.move_tank(180, 'degrees', 30, -30)
pair.move_tank(63, 'cm', 30, 30)
pair.move_tank(180, 'degrees', -30, 30)
pair.move_tank(10, 'cm', 30, 30)
motor.run_for_degrees(130)
pair.move_tank(5, 'cm', -30, -30)
motor.run_for_degrees(-130)
pair.move_tank(5, 'cm', -30, -30)
pair.move_tank(180, 'degrees', -30, 30)
pair.move_tank(63, 'cm', 30, 30)
pair.move_tank(180, 'degrees', -30, 30)
pair.move_tank(63, 'cm', 30, 30)
#pair.move_tank(70, 'cm', -30, -30)

pair = MotorPair('E', 'F')
pair.move_tank(91, 'cm', 30, 30)
#3텔레비전

from spike import Motor, MotorPair
pair = MotorPair('E', 'F')
motor = Motor('C')
motor.set_default_speed(100)
pair.move_tank(64, 'cm', 30, 30)
pair.move_tank(60, 'cm', -30, -30)
#4풍력발전

from spike import Motor, MotorPair
pair = MotorPair('E', 'F')
motor = Motor('C')
def song():
        hub.speaker.beep(69, 0.2)
        hub.speaker.beep(74, 0.2)
        hub.speaker.beep(76, 0.2)
        hub.speaker.beep(78, 0.2)
        hub.speaker.beep(76, 0.4)
        hub.speaker.beep(74, 0.2)
        hub.speaker.beep(74, 0.2)
        wait_for_seconds(0.9)

    hub.speaker.beep(69, 0.2)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.2)
    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(76, 0.4)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.4)
    hub.speaker.beep(78, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.2)
    wait_for_seconds(0.9)

    hub.speaker.beep(69, 0.2)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.2)
    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(76, 0.4)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(74, 0.2)
    wait_for_seconds(0.9)

    hub.speaker.beep(69, 0.2)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.2)
    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(76, 0.4)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.4)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.2)
    wait_for_seconds(0.9)

    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(79, 0.2)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.4)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(79, 0.2)
    wait_for_seconds(0.9)

    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(79, 0.2)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(81, 0.4)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(79, 0.2)
    wait_for_seconds(0.9)

    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.2)
    hub.speaker.beep(78, 0.4)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.4)
    wait_for_seconds(0.1)
    hub.speaker.beep(78, 0.2)
    wait_for_seconds(0.9)

    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(83, 0.2)
    wait_for_seconds(0.1)
    hub.speaker.beep(83, 0.2)
    hub.speaker.beep(78, 0.2)
    hub.speaker.beep(76, 0.2)
    hub.speaker.beep(74, 0.2)
    hub.speaker.beep(76, 0.4)
    wait_for_seconds(0.9)
motor.set_default_speed(100)
pair.move_tank(70, 'cm', 30, 30)
pair.move_tank(180, 'degrees', 30, -30)
pair.move_tank(41, 'cm', 30, 30)
pair.move_tank(12, 'cm', 50, 50)
pair.move_tank(10, 'cm', -30, -30)
pair.move_tank(12, 'cm', 50, 50)
pair.move_tank(10, 'cm', -30, -30)
pair.move_tank(12, 'cm', 50, 50)
pair.move_tank(10, 'cm', -30, -30)
pair.move_tank(12, 'cm', 50, 50)
pair.move_tank(10, 'cm', -30, -30)
pair.move_tank(12, 'cm', 50, 50)
pair.move_tank(10, 'cm', -30, -30)
pair.move_tank(12, 'cm', 50, 50)
pair.move_tank(10, 'cm', -30, -30)
pair.move_tank(50, 'cm', -30, -30)
pair.move_tank(180, 'degrees', 30, -30)
pair.move_tank(70, 'cm', 30, 30)
song()

#저수지(5번)

from spike import Motor, MotorPair
pair = MotorPair('E', 'F')
motor = Motor('C')
motor.set_default_speed(100)
pair.move_tank(60, 'cm', 30, 30)
pair.move_tank(180, 'degrees', 30, -30)
pair.move_tank(10, 'cm', 30, 30)
motor.run_for_degrees(180)
wait_for_seconds(1)
motor.run_for_degrees(-130)
motor.run_for_degrees(160)
motor.run_for_degrees(-130)
pair.move_tank(15, 'cm', -30, -30)
pair.move_tank(180, 'degrees', 30, -30)
pair.move_tank(64, 'cm', 30, 30)
# #태양광 발전소 (6번)
from spike import Motor, MotorPair
pair = MotorPair('E', 'F')
motor = Motor('C')
motor.set_default_speed(100)
pair.move_tank(75, 'cm', 30, 30)
pair.move_tank(180, 'degrees', 30, -30)
pair.move_tank(27, 'cm', 30, 30)
pair.move_tank(180, 'degrees', -30, 30)
pair.move_tank(14, 'cm', 30, 30)
motor.run_for_degrees(130)
pair.move_tank(14, 'cm', -30, -30)
pair.move_tank(180, 'degrees', -30, 30)
pair.move_tank(27, 'cm', 30, 30)
pair.move_tank(180, 'degrees', -30, 30)
pair.move_tank(80, 'cm', 30, 30)
감추기
Login Successful
이 글타래에 답글 달기...












선택된 파일 없음





