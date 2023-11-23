
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



























































