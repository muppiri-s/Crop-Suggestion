from flask import Flask, request, jsonify
app = Flask(__name__)
# root
@app.route("/")
def index():
"""
this is a root dir of my server
:return: str
"""
return "This is root!!!!"
# GET
@app.route('/months/<month>')
def hello_month(month):
"""
this serves as a demo purpose
:param month:
:return: str
"""
return "This is %s!" % month
# POST
@app.route('/api/post_some_data', methods=['POST'])
def get_text_prediction():
"""

predicts requested text whether it is ham or spam
:return: json
"""
json = request.get_json()
print(json)
if len(json['text']) == 0:
return jsonify({'error': 'invalid input'})
return jsonify({'Temperature will be': json['text']})
if __name__ == '__main__':
app.run(host='127.0.0.1', port=5000)
