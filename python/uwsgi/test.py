#!/usr/bin/python

import cgi

def application(env,start_response):
    start_response('200 OK',[('Content_Type','text/html')])
    #return "Congraduation benz!!! uWSGI Testing OK!!!"

    html = "<h1>Hello World From Python</h1>\n"
    html += "<table>\n"
    for k in env:
        html += "<tr><td>{}</td><td>{}</td></tr>\n".format(k, env[k])
    html += "</table>\n"

    form = cgi.FieldStorage(environ=env)
    if 'txt' in form:
        html += "<hr>You said: <b>{}</b>\n".format(form['txt'].value)
    else:
        html += "<hr>You said no word\n"

    return html
