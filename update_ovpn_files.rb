require 'tempfile'
require 'fileutils'

file_array = Dir['/Users/roger.robertson/Downloads/ProtonVPN_server_configs/*']

begin
    file_array.each do |ovpn|
        File.open(ovpn, 'r') do |file|
            temp_file = Tempfile.new("#{File.basename(file)}.modified")
            puts "Opening #{File.basename(file)}"
            file.each_line do |line|
                if line =~ /(auth-user-pass)/
                    temp_file.print line.chomp + " login.conf\n"
                    puts "Modifying login."
                else
                    temp_file.puts line 
                end
            end
            FileUtils.mv(temp_file, "/Users/roger.robertson/Downloads/pvpn/#{File.basename(file)}")
        end
    end
end