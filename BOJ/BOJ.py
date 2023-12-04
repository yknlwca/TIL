
# while 1:
#     a,b,c= map(int,input().split())
#
#     if a == 0 :
#         break
#     elif a == b == c:
#         print('Equilateral')
#     elif a == b or b == c or c == a:
#         print('Isosceles')
#     elif a + b <= c or b + c <= a or c + a <= b:
#         print('Invalid')
#     else:
#         print('Scalene')





# while 1:
#     n = list(map(int, input().split()))
#
#     if n == [0, 0, 0]:
#         break
#     n.sort()
#     if n[0] + n[1] <= n[2]:
#         print("Invalid")
#     elif n[0] == n[1] == n[2]:
#         print("Equilateral")
#     elif n[0] == n[1] or n[1] == n[2]:
#         print("Isosceles")
#     else:
#         print("Scalene")
#
#
# while 1:
#     A, B = map(int, input().split())
#     if A ==0 and B ==0:
#         break
#
#     if A > B :
#         print('Yes')
#     else:
#         print('No')



# def count_points_after_steps(n):
#     if n == 1:
#         return 9
#     else:
#         return 4 * count_points_after_steps(n - 2)
# n = int(input())
# print(count_points_after_steps(n))

# def jum(n):
#     if n == 1:
#         return 9
#     else:
#         return 4 * jum(n)
#



# grid = [list(map(int, input().split())) for _ in range(9)]
#
# max_value = 0
# max_row = 0
# max_col = 0
#
# for row in range(9):
#     for col in range(9):
#         if grid[row][col] >= max_value:
#             max_value = grid[row][col]
#             max_row = row + 1
#             max_col = col + 1
#
# print(max_value)
# print(max_row, max_col)

# N , M = map(int,input().split())
# A = []
# B = []
# for i in range(N):
#     for j in range(M):
#

# def money(cent):
#     quarter = cent // 25
#     cent %= 25
#     dime = cent // 10
#     cent %= 10
#     nickel = cent // 5
#     penny = cent % 5
#     return quarter, dime, nickel, penny
#
# T = int(input())
#
# for _ in range(T):
#     change = int(input())
#
#     result = money(change)
#     print(*result)


# stu = list(range(1,31))
#
# for _ in range(28):
#     n = int(input())
#     stu.remove(n)
# print(min(stu))
# print(max(stu))


# def cgy(A, B):
#     while B != 0:
#         A,B = B, A%B
#     return A
#
# def cgb(A,B):
#     return (A*B) // cgy(A,B)
#
# T = int(input())
# for _ in range(T):
#     A,B = map(int,input().split())
#     print(cgb(A,B))

# R1 , S = map(int,input().split())
# print((2*S-R1))

# H, M, S = map(int, input().split())
# T = int(input())
# S += T
#
# while S >= 60:
#     M += S // 60
#     S = S % 60
#
# while M >= 60:
#     H += M // 60
#     M = M % 60
#
# while H >= 24:
#     H = H % 24
#
# print(H, M, S)


# A, I = map(int,input().split())
#
# print(round((A * I) - (A - 1)))



# A,B,C = map(int,input().split())
# print((A+B+C)-max(A,B,C)-min(A,B,C))


# A = int(input())
# B = input()
# C = int(input())
#
# if B == '+':
#     print(A+C)
# elif B == '*':
#     print(A*C)


# WS = int(input())
# SH = int(input())
# SG = int(input())
# SY = int(input())
# GS = int(input())
#
# if WS < 40 :
#     WS = 40
# if SH < 40 :
#     SH = 40
# if SG < 40 :
#     SG = 40
# if SY < 40 :
#     SY = 40
# if GS < 40 :
#     GS = 40
#
# print((WS+SH+SG+SY+GS)//5)



#
# T = int(input())
# for _ in range(T):
#     K = input().split()
#     num = float(K[0])
#     for i in range(1,len(K)):
#         if i == '@':
#             num *= 3
#         elif i == '%':
#             num += 5
#         elif i == '#':
#             num -= 7
#         print(num)


# def calculate_expression(expression):
#     result = float(expression[0])
#     for i in range(1, len(expression), 2):
#         operator = expression[i]
#         operand = float(expression[i + 1])
#
#         if operator == '@':
#             result *= 3
#         elif operator == '%':
#             result += 5
#         elif operator == '#':
#             result -= 7
#
#         result = round(result + operand, 2)
#
#     return result
#
# def main():
#     T = int(input())  # 테스트 케이스의 개수
#
#     for _ in range(T):
#         expression = input().split()
#         result = calculate_expression(expression)
#         print(f'{result:.2f}')
#
# if __name__ == "__main__":
#     main()

#
# K,M,N = map(int,input().split())
# snack = K*M
# if N >= snack:
#     print(0)
# elif N < snack:
#     print(snack-N)


# A,B = map(int,input().split())
# print(A+B)


# N = int(input())
# lst = []
# for _ in range(N):
#     T = int(input())
#     lst.append(T)
# if N/2 < sum(lst):
#     print('Junhee is cute!')
# elif N/2 > sum(lst):
#     print('Junhee is not cute!')



# while 1:
#     M, F = map(int, input().split())
#     if M == 0 and F == 0:
#         break
#     print(M+F)


# K = int(input())
# M = input()
# if M.count('A') == M.count('B'):
#     print('Tie')
# elif M.count('A') > M.count('B'):
#     print('A')
# else:
#     print('B')


# def alien_operator(num, operator):
#     if operator == '@':
#         return num * 3
#     elif operator == '%':
#         return num + 5
#     elif operator == '#':
#         return num - 7
# def calculate_alien_expression(expression):
#     num, operators = expression.split(' ')
#     num = float(num)
#     for operator in operators:
#         num = alien_operator(num, operator)
#     return round(num, 2)
# T = int(input())
# for _ in range(T):
#     expression = input()
#     result = calculate_alien_expression(expression)
#     print(f'{result:.2f}')


# T = int(input())
# for _ in range(T):
#     lst = list(input().split())
#     lst[0] = float(lst[0])
#     for i in range(1,len(lst)):
#         if lst[i] == '@':
#             lst[0] *= 3
#         elif lst[i] == '%':
#             lst[0] += 5
#         elif lst[i] == '#':
#             lst[0] -= 7
#     print(f'{lst[0]:.2f}')

# n = int(input())
# chang = 100
# sang = 100
# for _ in range(n):
#     c,s = map(int,input().split())
#     if c > s :
#         sang -= c
#     elif c < s :
#         chang -= s
#     else:
#         continue
# print(chang)
# print(sang)


# N = int(input())
# for _ in range(N):
#     r , e , c = map(int,input().split())
#     if r < e-c:
#         print('advertise')
#     elif r == e-c:
#         print('does not matter')
#     else:
#         print('do not advertise')



# N = int(input())
#
# prizes = []
# for _ in range(N):
#     dice = list(map(int, input().split()))
#     dice.sort()
#
#     if dice[0] == dice[2]:
#         prize = 10000 + dice[0] * 1000
#
#     elif dice[0] == dice[1] or dice[1] == dice[2]:
#         prize = 1000 + dice[1] * 100
#
#     else:
#         prize = dice[2] * 100
#
#     prizes.append(prize)
# print(max(prizes))


# N = int(input())
#
# S = 1000 - N
# k = 0
# while 1:
#     if S // 500 > 0 :
#         k += 1
#         S = S % 500
#     if S // 500 == 0 :
#         break
# while 1:
#     if S // 100 > 0 :
#         k += 1
#         S = S % 100
#     if S // 100 == 0:
#         break
# while 1:
#     if S // 50 > 0 :
#         k += 1
#         S = S % 50
#     if S // 50 == 0:
#         break
# while 1:
#     if S // 10 > 0 :
#         k += 1
#         S = S % 10
#     if S // 10 == 0:
#         break
# while 1:
#     if S // 5 > 0 :
#         k += 1
#         S = S % 5
#     if S // 5 == 0:
#         break
# while 1:
#     if S // 1 > 0 :
#         k += 1
#         S = S % 1
#     if S // 1 == 0:
#         break
# print(k)


# change = [500,100,50,10,5,1]
# money = 1000 - int(input())
# cnt = 0
#
# for c in change:
#     if money >= c:
#         cnt += money // c
#         money %= c
# print(cnt)


# n = int(input())
# Q1 = 0
# Q2 = 0
# Q3 = 0
# Q4 = 0
# AXIS = 0
# for _ in range(n):
#     a,b = map(int,input().split())
#     if a == 0 or b == 0:
#         AXIS += 1
#     elif a > 0 and b > 0 :
#         Q1 += 1
#     elif a > 0 and b < 0 :
#         Q4 += 1
#     elif a < 0 and b > 0 :
#         Q2 += 1
#     elif a < 0 and b < 0 :
#         Q3 += 1
# print(f'Q1: {Q1}')
# print(f'Q2: {Q2}')
# print(f'Q3: {Q3}')
# print(f'Q4: {Q4}')
# print(f'AXIS: {AXIS}')

# while 1:
#     lst = list(map(int,input().split()))
#     lst.sort()
#     if sum(lst) == 0 :
#         break
#
#     if lst[0]**2 + lst[1]**2 == lst[-1]**2:
#         print('right')
#     else:
#         print('wrong')


# T = int(input())
# lst1 = []
# for _ in range(T):
#     lst2 = list(map(int,input().split()))
#     lst1.append(lst2)
# x = [i[0] for i in lst1]
# y = [i[-1] for i in lst1]
#
# print((max(x)-min(x))*(max(y)-min(y)))



# 두변의 길이의 합이 나머지 한변의 길이보다 커야한다.
# 두변의 길이 합이 나머지 한변 길이 보다 작
# lst = list(map(int,input().split()))
# lst.sort()
# if lst[-1] <= lst[0]+lst[1]:
#     print(sum(lst))
# else:
#     lst[-1] = lst[0] + lst[1] -1
#     print(sum(lst))


# t = input()
# l = 10
# for i in range(len(t)-1):
#     if t[i+1] == t[i]:
#         l += 5
#     elif t[i+1] != t[i]:
#         l += 10
# print(l)


# t = int(input())
#
# for _ in range(t):
#     p = int(input())
#
#     max_price = 0
#     max_player = ""
#
#     for _ in range(p):
#         price, player = input().split()
#         price = int(price)
#
#         if price > max_price:
#             max_price = price
#             max_player = player
#
#     print(max_player)

# lst = []
# a = 0
# for _ in range(5):
#     b = int(input())
#     a += b
#     lst.append(b)
#     lst.sort()
# print(a // 5)
# print(lst[2])


# import math

#
# def find_min_sum_of_squares(m, n):
#     min_square = float('inf')
#     sum_of_squares = 0
#     has_square = False
#
#     for i in range(m, n + 1):
#         square_root = int(math.sqrt(i))
#         if square_root ** 2 == i:
#             has_square = True
#             min_square = min(min_square, i)
#             sum_of_squares += i
#
#     if not has_square:
#         return -1, -1
#     else:
#         return sum_of_squares, min_square
#
#
# m = int(input())
# n = int(input())
#
# sum_of_squares, min_square = find_min_sum_of_squares(m, n)
# print(sum_of_squares)
# print(min_square)



# import math
#
# M = int(input())
# N = int(input())
# lst = []
#
# for i in range(M, N+1):
#     if int(math.sqrt(i))**2 == i:
#         lst.append(i)
#
# if not lst:
#     print(-1)
# else:
#     print(sum(lst))
#     print(lst[0])


# from datetime import datetime
#
# def find_age_range(students):
#     youngest = float('inf')
#     oldest = 0
#     youngest_name = ""
#     oldest_name = ""
#
#     for student in students:
#         name, day, month, year = student.split()
#         birthday = datetime(int(year), int(month), int(day))
#         age = (datetime.now() - birthday).days // 365
#
#         if age < youngest:
#             youngest = age
#             youngest_name = name
#
#         if age > oldest:
#             oldest = age
#             oldest_name = name
#
#     return youngest_name, oldest_name
#
# # 입력 받기
# n = int(input())
# student_list = [input() for _ in range(n)]
#
# # 결과 출력
# youngest, oldest = find_age_range(student_list)
# print(youngest)
# print(oldest)



# def fibonacci(n):
#     fib = [0, 1]
#
#     for i in range(2, n + 1):
#         fib.append(fib[i - 1] + fib[i - 2])
#
#     return fib[n]
#
# n = int(input())
#
# result = fibonacci(n)
# print(result)


# N = int(input())
# for i in range(N,0,-1):
#     print(i)

# T = int(input())
# e = 0
# k = 0
# for _ in range(T):
#     N = int(input())
#     for _ in range(N):
#         a ,b = input().split()
#         c = int(a)
#         d = float(b)
#         e += c
#         k += (c*d)
# print(k/e)


# N,M = map(int,input().split())
# lst = list(map(int,input().split()))



# from itertools import combinations
#
# def find_nearest_sum(cards, target):
#     closest_sum = 0
#
#     for combination in combinations(cards, 3):
#         current_sum = sum(combination)
#
#         if current_sum == target:
#             return current_sum
#
#         if closest_sum < current_sum <= target:
#             closest_sum = current_sum
#
#     return closest_sum
#
# # 입력 받기
# N, M = map(int, input().split())
# cards = list(map(int, input().split()))
#
# # 결과 출력
# result = find_nearest_sum(cards, M)
# print(result)

# T = int(input())
# for _ in range(T):
#     s = int(input())
#     k = int(input())
#     for _ in range(k):
#         a,b = map(int,input().split())
#         s += a*b
#     print(s)


# N = int(input())
# a = 1
# for i in range(1,N+1):
#     a *= i
# print(a)

# a = int(input())
# lst = list(map(int,input().split()))
# cnt = 0
#
# for i in lst:
#     if i == a:
#         cnt += 1
# print(cnt)


# T = int(input())
# for _ in range(T):
#     N = int(input())
#     lst = list(map(int,input().split()))
#     print(sum(lst))

# lst = []
# a = 0
# for _ in range(7):
#     N = int(input())
#     if N % 2 == 1:
#         lst.append(N)
#         a += N
# if a == 0:
#     print(-1)
# else:
#     print(a)
#     lst.sort()
#     print(lst[0])



# def fibo(n):
#     fib = [0, 1]
#
#     for i in range(2, n + 1):
#         fib.append(fib[i - 1] + fib[i - 2])
#
#     return fib[n]
#
# n = int(input())
# print(fibo(n))


# A,B = map(int,input().split())
#
# C = []
# if A == 1 and B == 1:
#     print(1)
# else:
#     for i in range(B):
#         if i == 0 :
#             pass
#         else:
#             for j in range(i):
#                 C.append(i)
#     print(sum(C[A-1:B]))

# T = int(input())
# for _ in range(T):
#     lst = list(map(int,input().split()))
#     lst.sort()
#     print(lst[-3])

# a,b = map(int,input().split())
#
# lst = []
# for i in range(1,max(a,b)+1):
#     if a % i == 0 and b % i ==0:
#         lst.append(i)
# k = (a*b) // lst[-1]
#
# print(lst[-1])
# print(k)


# N = int(input())
# lst = []
# for _ in range(N):
#     a = int(input())
#     lst.append(a)
# lst.sort()
# for i in lst:
#     print(i)

# K = int(input())
# lst = []
# for _ in range(K):
#     a = int(input())
#     if a != 0:
#         lst.append(a)
#     elif a == 0 :
#         lst.pop()
# print(sum(lst))


# N = int(input())
# members = []
#
# for i in range(N):
#     age, name = input().split()
#     members.append((int(age), name, i))
#
# members.sort(key=lambda x: (x[0], x[2]))
#
# for member in members:
#     print(member[0], member[1])

# a, b = input().split()
# a = a[::-1]
# b = b[::-1]
# a = int(a)
# b = int(b)
# result = str(a+b)
# print(int(result[::-1]))


#
# T = int(input())
# for x in range(T):
#     print(f'Class {x+1}')
#     lst = []
#     lst1 = []
#     lst = list(map(int , input().split()))
#     lst.remove(lst[0])
#     lst.sort()
#     for i in range(len(lst)-1):
#         k = lst[i+1] - lst[i]
#         lst1.append(k)
#     print(f'Max {max(lst)}, Min {min(lst)}, Largest gap {max(lst1)}')

# 퀵 정렬 공부하기
# N = int(input())
# lst = []
# for _ in range(N):
#     a = int(input())
#     lst.append(a)
#     lst.sort()
# for i in lst:
#     print(i)




















































































