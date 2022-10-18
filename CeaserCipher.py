def cipher(text, amount):
    encrypt = ""
    amount = amount % 26
    
    for x in range(len(text)):
        if text[x] != " ":
            encrypt += chr(ord("a") + (((ord(text[x]) - ord("a")) + amount) % 26))
        else:
            encrypt += " ";
        
    return encrypt

def decipher(text, amount):
    return cipher(text, 26 - (amount % 26))

def bruteForce(text):
        for x in range(26):
            print(x, ":", decipher(text, x))

bruteForce("odkbfamzmxkeue")
