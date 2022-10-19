import math
import sys
sys.setrecursionlimit(3000)

def power(x, y):
    if(y == 1):
        return x
    return(x * (power(x, y - 1)))

def gcd (x, y):
    if y == 0:
        return x
    return gcd(y, x % y)
    
def getPrivateKey(phi, e):
    return int(((2 * phi) + 1)/e)
    
def getKeys(p, q):
    phi = (p-1)*(q-1)
    for e in range(2, phi):
        if gcd(e, phi) == 1:
            return [[p * q, e], [p * q, getPrivateKey(phi, e)]]
    return -1

def encrypt(plainText, publicKey):
    return math.fmod(power(plainText, publicKey[1]), publicKey[0])

def decrypt(cipherText, privateKey):
    return math.fmod(power(cipherText, privateKey[1]), privateKey[0])

keys = getKeys(3, 7)
encrypt = encrypt(19, keys[0])
decrypt = decrypt(encrypt, keys[1])

print(encrypt, decrypt)
